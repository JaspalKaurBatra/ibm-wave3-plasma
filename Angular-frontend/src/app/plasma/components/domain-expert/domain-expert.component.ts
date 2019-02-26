import { DomainExpertService } from './../../services/domain-expert.service';
import { Component, OnInit, Input } from '@angular/core';
import { Domainexpert } from '../../tsclasses/domainexpert';
import { HttpClient } from '@angular/common/http';


@Component({
  selector: 'app-domain-expert',
  templateUrl: './domain-expert.component.html',
  styleUrls: ['./domain-expert.component.css']
})
export class DomainExpertComponent implements OnInit {
  value: string;
  @Input()
  // private regform: Domainexpert;
  private regform;
  private domain: string;
  private concept: string[];
  // private domain: any;
  private concepts: any [];

  private domainName: any;
  private conceptsAll: any[];
  conceptList: any[] = [];

   onChange(event) {
    console.log(event);
    this.conceptList.push(event);
 }
  send(event: Domainexpert) {
    this.regform = new Domainexpert();
    this.regform.domain = this.domainName;
    this.regform.concepts = this.conceptList;
    // this.value = event.target.value;
    console.log('first cal');
    console.log(this.regform);
    this.search.add(this.regform).subscribe(data => {
      console.log(data);
    });

   }
   constructor(private search: DomainExpertService,  private http: HttpClient) {

    this.search.getTheData().subscribe((data: any) => {
      this.conceptsAll = data.concepts;
  });
  }
  ngOnInit() {

  }
  // onClick() {
  //   console.log({Domain: this.domainName});
  //  // console.log({Concepts: this.concepts});
  //  console.log(this.conceptList);
  // }
}
