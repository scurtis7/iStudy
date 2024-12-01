import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-study-note',
  templateUrl: './study-note.component.html',
  styleUrl: './study-note.component.scss'
})
export class StudyNoteComponent implements OnInit {

  showEditControls = false;
  buttonTitle = 'Edit Note';

  verse = 'Genesis 1:1 - 1:5 ';
  note = 'In the beginning God created the heavens and the earth.';

  constructor() {
  }

  ngOnInit(): void {
  }

  editNote() {
    this.showEditControls = !this.showEditControls;
    if (this.showEditControls) {
      this.buttonTitle = 'Save Note';
    } else {
      this.buttonTitle = 'Edit Note';
    }
  }

}
