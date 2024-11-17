import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { StudyMethod } from "../model/study-method";

@Injectable({
  providedIn: 'root'
})
export class HttpService {

  constructor(private http: HttpClient) {
  }

  public getStudyMethods(): Observable<StudyMethod[]> {
    return this.http.get<StudyMethod[]>(`http://localhost:8080/methods`);
  }

}
