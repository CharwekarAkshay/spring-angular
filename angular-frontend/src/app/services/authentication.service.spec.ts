import { HttpClientTestingModule } from '@angular/common/http/testing';
import { TestBed } from '@angular/core/testing';
import { AuthenticationService } from './authentication.service';



describe('AuthenticationService', () => {
  let service: AuthenticationService;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
    });
    service = TestBed.inject(AuthenticationService);
  });

  it('Login Success', () => {
    let response: JSON;

    service.login('AkshayCharwekar', 'password').subscribe(
      success => {
        response = success;
        expect(response != null).toBeTruthy();
      },
      error => {
        response = error;
        expect(response != null).toBeTruthy();
      }
    );

  });
});
