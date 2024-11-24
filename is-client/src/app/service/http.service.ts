import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { StudyMethod } from "../model/study-method";
import { Study } from "../model/study";

@Injectable({
  providedIn: 'root'
})
export class HttpService {

  constructor(private http: HttpClient) {
  }

  public getStudyMethods(): Observable<StudyMethod[]> {
    return this.http.get<StudyMethod[]>(`http://localhost:8080/methods`);
  }

  public getAllStudies(): Observable<Study[]> {
    return this.http.get<Study[]>(`http://localhost:8080/study`);
  }

  public getStudyById(id: number): Observable<Study> {
    return this.http.get<Study>(`http://localhost:8080/study/${id}`);
  }

  public saveStudy(study: Study): Observable<Study> {
    return this.http.post<Study>(`http://localhost:8080/study`, study);
  }

  public deleteStudy(id: number): Observable<any> {
    return this.http.delete(`http://localhost:8080/study/${id}`);
  }

}
