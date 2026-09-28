import { Component, OnInit } from '@angular/core';
import { Study } from "../../model/study";
import { DialogService, DynamicDialogRef } from 'primeng/dynamicdialog';
import { NewStudyComponent } from "./new-study/new-study.component";
import { HttpService } from "../../service/http.service";
import { Router } from "@angular/router";

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrl: './dashboard.component.scss'
})
export class DashboardComponent implements OnInit {

  studies: Study[] = [];

  constructor(private dialogService: DialogService, private httpService: HttpService, private router: Router) {
  }

  ngOnInit() {
    this.getStudies();
  }

  newStudy() {
    const ref: DynamicDialogRef = this.dialogService.open(NewStudyComponent, {
      header: 'New Study',
      data: new Study(),
      closable: false,
      width: '500px'
    });
    ref.onClose.subscribe((result: Study) => {
      if (result) {
        this.httpService.saveStudy(result).subscribe({
          next: () => this.getStudies(),
          error: (err: Error) => console.log(err)
        });
      }
    });
  }

  launchStudy(id: number) {
    this.router.navigate(['/study'], { queryParams: { id: id } });
  }

  removeStudy(id: number) {
    this.httpService.deleteStudy(id).subscribe({
      next: () => this.getStudies(),
      error: (err: Error) => console.log(err)
    });
  }

  private getStudies() {
    this.httpService.getAllStudies().subscribe({
      next: (studies: Study[]) => {
        this.studies = studies;
      }
    });
  }

}
