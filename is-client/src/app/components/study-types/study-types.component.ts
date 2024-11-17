import { Component, OnInit } from '@angular/core';
import { HttpService } from "../../service/http.service";
import { StudyMethod } from "../../model/study-method";

@Component({
  selector: 'app-study-types',
  templateUrl: './study-types.component.html',
  styleUrl: './study-types.component.scss'
})
export class StudyTypesComponent implements OnInit {

  selectedType = '';
  categories: StudyMethod[] = [];

  constructor(private httpService: HttpService) {
  }

  ngOnInit(): void {
    this.getMethods();
  }

  getMethods() {
    this.httpService.getStudyMethods().subscribe({
      next: (categories: StudyMethod[]) => {
        this.categories = categories;
        this.selectedType = categories[0].name;
      }
    });
  }

}
