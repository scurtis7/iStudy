import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from "@angular/router";
import { Observable } from "rxjs";
import { Study } from "../../model/study";
import { HttpService } from "../../service/http.service";

@Component({
  selector: 'app-study',
  templateUrl: './study.component.html',
  styleUrl: './study.component.scss'
})
export class StudyComponent implements OnInit {

  study: Study;

  constructor(private route: ActivatedRoute, private httpService: HttpService) {
  }

  ngOnInit(): void {
    this.route.queryParams.subscribe(params => {
      this.loadStudy(params['id']);
    });
  }

  private loadStudy(id: number): void {
    this.httpService.getStudyById(id).subscribe({
      next: (result) => {
        this.study = result;
      },
      error: (err) => {
        console.log(err);
      }
    });
  }

}
