import { Component, Input, OnInit } from '@angular/core';
import { MenuItem } from 'primeng/api';
import { Router } from '@angular/router';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrl: './menu.component.scss'
})
export class MenuComponent implements OnInit {

  @Input() pageTitle: string;

  menuItems: MenuItem[];

  constructor(private router: Router) {
  }

  ngOnInit() {
    this.menuItems = [
      { label: 'Dashboard', command: () => this.router.navigate(['/dashboard']) },
      { label: 'Study Methods', command: () => this.router.navigate(['/study-types']) },
      { label: 'Administration', command: () => this.router.navigate(['/admin']) }
    ];
  }

}
