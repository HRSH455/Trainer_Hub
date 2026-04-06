import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Trainer } from '../models/trainer.model';
import { PaginatedTrainers } from '../models/paginatedTrainers.model';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class TrainerService {

  // public apiUrl:string='http://localhost:3001/trainers';
  private baseUrl = environment.apiUrl;

  constructor(private http:HttpClient) { }

  getAllTrainers():Observable<any>
  {
    return this.http.get(`${this.baseUrl}/trainer`);
  }

  getTrainerById(trainerId:number):Observable<any>
  {
    return this.http.get(`${this.baseUrl}/trainer/${trainerId}`);
  }

  addTrainer(trainer:Trainer):Observable<any>
  {
    return this.http.post(`${this.baseUrl}/trainer`,trainer);
  }

  updateTrainer(trainerId:number,trainer:Trainer):Observable<any>
  {
    return this.http.put(`${this.baseUrl}/trainer/${trainerId}`,trainer);
  }

  deleteTrainer(trainerId:number):Observable<void>
  {
    return this.http.delete<void>(`${this.baseUrl}/trainer/${trainerId}`);
  }


  getTrainersByPages(page:number,size:number):Observable<PaginatedTrainers>
  {
    return this.http.get<any>(`${this.baseUrl}/trainers?page=${page}&size=${size}`);
  }
}
