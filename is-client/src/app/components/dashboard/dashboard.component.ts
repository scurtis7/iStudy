import { Component, OnInit, ViewChild } from '@angular/core';
import { MatSort } from "@angular/material/sort";
import { MatTableDataSource } from "@angular/material/table";
import { Study } from "../../model/study";
import { MatDialog, MatDialogConfig } from "@angular/material/dialog";
import { NewStudyComponent } from "./new-study/new-study.component";
import { HttpService } from "../../service/http.service";
import { Router } from "@angular/router";

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrl: './dashboard.component.scss'
})
export class DashboardComponent implements OnInit {

  @ViewChild(MatSort) sort: MatSort;

  displayedColumns: string[] = ['remove', 'name', 'method', 'description', 'createdDate'];
  dataSource: MatTableDataSource<Study> = new MatTableDataSource<Study>();

  private studies: Study[];

  constructor(private dialog: MatDialog, private httpService: HttpService, private router: Router) {
  }

  ngOnInit() {
    this.getStudies();
  }

  private resetDatasource() {
    this.dataSource.data = this.studies;
    this.dataSource.sort = this.sort;
  }

  newStudy() {
    const dialogConfig = new MatDialogConfig();
    dialogConfig.disableClose = true;
    dialogConfig.data = new Study();
    const dialogRef = this.dialog.open(NewStudyComponent, dialogConfig);
    dialogRef.afterClosed().subscribe(result => {
      if (result) {
        this.httpService.saveStudy(result).subscribe({
          next: (study: Study) => {
            this.getStudies();
          },
          error: (err: Error) => {
            console.log(err);
          }
        });
      }
    });
  }

  launchStudy(id: number) {
    this.router.navigate(
      ['/study'],
      { queryParams: { id: id } }
    );
  }

  removeStudy(id: number) {
    this.httpService.deleteStudy(id).subscribe({
      next: (result: any) => {
        this.getStudies();
      },
      error: (err: Error) => {
        console.log(err);
      }
    });
  }

  private getStudies() {
    this.httpService.getAllStudies().subscribe({
      next: (studies: Study[]) => {
        this.studies = studies;
        this.resetDatasource();
      }
    });
  }

}
