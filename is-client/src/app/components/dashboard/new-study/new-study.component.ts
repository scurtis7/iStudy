import { Component, Inject, OnInit } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from "@angular/material/dialog";
import { Study } from "../../../model/study";
import { StudyMethod } from "../../../model/study-method";
import { HttpService } from "../../../service/http.service";
import { HttpErrorResponse } from "@angular/common/http";

@Component({
  selector: 'app-new-study',
  templateUrl: './new-study.component.html',
  styleUrl: './new-study.component.scss'
})
export class NewStudyComponent implements OnInit {

  studyMethodError = false;
  studyNameError = false;

  methods: StudyMethod[] = [];

  constructor(@Inject(MAT_DIALOG_DATA) public study: Study, public dialogRef: MatDialogRef<NewStudyComponent>,
              public httpService: HttpService) {
  }

  ngOnInit(): void {
    this.study.method = '';
    this.getStudyMethods();
  }

  close(save: boolean) {
    if (save) {
      if (this.isStudyValid()) {
        this.dialogRef.close(this.study);
      }
    } else {
      this.dialogRef.close(null);
    }
  }

  private isStudyValid(): boolean {
    this.studyMethodError = false;
    this.studyNameError = false;
    if (this.study.method == undefined || this.study.method == '') {
      this.studyMethodError = true;
    }
    if (this.study.name == undefined || this.study.name == '') {
      this.studyNameError = true;
    }
    return !this.studyMethodError && !this.studyNameError;
  }

  private getStudyMethods() {
    this.httpService.getStudyMethods().subscribe({
        next: (response: StudyMethod[]) => {
          this.methods = response;
        },
        error: (error: HttpErrorResponse) => {
          console.log(error.message);
        }
      }
    );
  }

}
