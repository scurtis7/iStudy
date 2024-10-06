import { Component, OnInit } from '@angular/core';
import { HttpService } from "../../service/http.service";
import { Category } from "../../model/category";

@Component({
  selector: 'app-study-types',
  templateUrl: './study-types.component.html',
  styleUrl: './study-types.component.scss'
})
export class StudyTypesComponent implements OnInit {

  selectedType = '';
  categories: Category[] = [];

  constructor(private httpService: HttpService) {
  }

  ngOnInit(): void {
    this.getCategories();
  }

  getCategories() {
    this.httpService.getCategories().subscribe({
      next: (categories: Category[]) => {
        this.categories = categories;
        this.selectedType = categories[0].name;
      }
    });
  }

}
