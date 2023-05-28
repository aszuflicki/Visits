import { Component } from '@angular/core';
import { VisitsService } from '../visits.service';
import { VisitsADay } from '../visitsaday';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent {

  ip: string = '';
  date: string = '';
  stats: VisitsADay | undefined;

  constructor(private visitService: VisitsService) {}

  submit(): void {
    this.visitService.submitVisit(this.date, this.ip).subscribe();
  }

}
