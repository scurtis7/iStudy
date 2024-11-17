import { Component, OnInit, ViewChild } from '@angular/core';
import { MatSort } from "@angular/material/sort";
import { MatTableDataSource } from "@angular/material/table";
import { Study } from "../../model/study";

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrl: './dashboard.component.scss'
})
export class DashboardComponent implements OnInit {

  @ViewChild(MatSort) sort: MatSort;

  displayedColumns: string[] = ['id', 'name', 'method', 'description', 'created_date'];
  // displayedColumns: string[] = ['name', 'description'];
  dataSource: MatTableDataSource<Study> = new MatTableDataSource<Study>();

  private studies: Study[];

  constructor() {
  }

  ngOnInit() {
    this.getStudies();
    this.resetDatasource();
  }

  private resetDatasource() {
    this.dataSource.data = this.studies;
    this.dataSource.sort = this.sort;
  }

  private getStudies() {
    this.studies = [
      {
        "id": 1,
        "method": "method",
        "name": "name",
        "description": "description",
        "created_date": new Date(),
      }
    ]
  }

}
