import { Component, AfterViewInit } from '@angular/core';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClient } from '@angular/common/http';

import { CanvasJSAngularChartsModule } from '@canvasjs/angular-charts';

@Component({
  selector: 'app-statistics',
  templateUrl: './statistics.component.html',
  styleUrls: ['./statistics.component.scss']
})
export class StatisticsComponent implements AfterViewInit {
  dataPoints:any = [];
  chart:any;

  constructor(private http : HttpClient) {
  }

  chartOptions = {
    theme: "light2",
    animationEnabled: true,
    title: {
      text:"website visits"
    },
    subtitles: [{
      text: "Loading Data...",
      fontSize: 24,
      horizontalAlign: "center",
      verticalAlign: "center",
      dockInsidePlotArea: true,

    }],
    axisY: {
      title: "Visits"
    },
    axisX: {
      interval: 1,
      intervalType: "day",
    },
    data: [{
      type: "line",
      name: "visits",
      xValueType: "dateTime",
      dataPoints: this.dataPoints
    }]
  }

  getChartInstance(chart: object) {
    this.chart = chart;
  }

  ngAfterViewInit() {
    this.http.get('/api/visit/statistics', { responseType: 'json' }).subscribe((response: any) => {
      let data = response;
      for(let i = 0; i < data.length; i++){
        if (data[i].date == null) continue;
        this.dataPoints.push({x: new Date(data[i].date), y: Number(data[i].count) });
      }
      this.chart.subtitles[0].remove();
    });
  }
}
