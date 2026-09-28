import { NgModule } from '@angular/core';
import { TableModule } from 'primeng/table';
import { ButtonModule } from 'primeng/button';
import { MenuModule } from 'primeng/menu';
import { DynamicDialog } from 'primeng/dynamicdialog';

@NgModule({
  imports: [
    TableModule,
    ButtonModule,
    MenuModule,
    DynamicDialog
  ],
  exports: [
    TableModule,
    ButtonModule,
    MenuModule,
    DynamicDialog
  ]
})
export class PrimengModule {
}
