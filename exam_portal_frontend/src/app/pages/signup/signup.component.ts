import {Component, OnInit} from '@angular/core';
import {User} from "../../models/User";
import {UserService} from "../../services/user.service";
import {CoreService} from "../../services/core/core.service";
import Swal from 'sweetalert2';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.scss']
})
export class SignupComponent implements OnInit {

  public user: User = {
    username: '',
    password: '',
    firstName: '',
    lastName: '',
    email: '',
    phone: ''
  };

  constructor(private _userService: UserService, private _snackBar: CoreService) {
  }

  ngOnInit() {
  }

  formSubmit() {
    if (this.user.username == '' || this.user.username == null) {
      this._snackBar.showSnackBar('Username required', 'ok');
      return;
    }
    this._userService.addUser(this.user).subscribe({
      next: (response: any) => {
        console.log(response);
        Swal.fire('Success', response.id, 'success')
      }, error: (error) => {
        console.error(error);
        Swal.fire('Error', error.error.message, 'error');
      }
    });
  }
}
