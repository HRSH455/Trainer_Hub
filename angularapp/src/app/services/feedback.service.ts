import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Feedback } from '../models/feedback.model';
import { Observable } from 'rxjs';
import { paginatedFeedbacks } from '../models/paginatedFeedbacks.model';
import { environment } from 'src/environments/environment.prod';

@Injectable({
  providedIn: 'root'
})
export class FeedbackService {
  private baseUrl = environment.apiUrl; 

  // public apiUrl:string='http://localhost:3001/feedback';



  constructor(private http:HttpClient) { }


  sendFeedback(feedback:Feedback):Observable<any>
  {
    return this.http.post(`${this.baseUrl}/feedback`,feedback);
  }

  getAllFeedbacksByUserId(userId:number):Observable<any>
  {
    return this.http.get(`${this.baseUrl}/feedback/user/${userId}`);
  }

  deleteFeedback(feedbackId:number):Observable<any>
  {
    return this.http.delete(`${this.baseUrl}/feedback/${feedbackId}`);
  }

  getFeedbacks():Observable<any>
  {
    return this.http.get(`${this.baseUrl}/feedback`);
  }


  getFeedbacksByPages(page:number,size:number):Observable<paginatedFeedbacks>
  {
    return this.http.get<any>(`${this.baseUrl}/feedback?page=${page}&size=${size}`);
  }

}
