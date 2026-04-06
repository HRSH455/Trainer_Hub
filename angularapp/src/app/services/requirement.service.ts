import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Requirement } from '../models/requirement.model';
import { PaginatedRequirements } from '../models/paginatedRequirements.model';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class RequirementService {
  private baseUrl = environment.apiUrl; 

  constructor(private http:HttpClient) { }

  getAllRequirements():Observable<any>
  {
    return this.http.get(`${this.baseUrl}/requirement`);
  }

  getRequirementById(requirementId:number):Observable<any>
  {
    return this.http.get(`${this.baseUrl}/requirement/${requirementId}`);
  }

  addRequirement(requirement:Requirement):Observable<any>
  {
    console.log('in service');
    return this.http.post(`${this.baseUrl}/requirement`,requirement);
  }

  updateRequirement(requirementId:any,requirement:Requirement):Observable<any>
  {
    return this.http.put(`${this.baseUrl}/requirement/${requirementId}`,requirement);
  }

  // updateRequirement(requirementId:number,requirement:Requirement):Observable<any>
  // {
  //   return this.http.put(`${this.baseUrl}/requirement/${requirementId}`,requirement);
  // }

  getRequirementsByTrainerId(trainerId:number):Observable<any>
  {
    return this.http.get(`${this.baseUrl}/trainer/${trainerId}`);
  }

  deleteRequirement(id:number):Observable<void>
  {
    console.log('in delete sevice');
    console.log(id);
    return this.http.delete<void>(`${this.baseUrl}/requirement/${id}`);
  }

  // deleteRequirement(requirementId:number):Observable<void>
  // {
  //   return this.http.delete<void>(`${this.baseUrl}/${requirementId}`);
  // }



  ///-----------------pagination--------------------///

  getRequirementsByPages(page:number,size:number):Observable<PaginatedRequirements>
  {
    return this.http.get<PaginatedRequirements>(`${this.baseUrl}/requirements?page=${page}&size=${size}`)
  }

}
