package booking_site.xws_proj.soap.web.services.example.student;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import booking_site.xws_proj.soap.beans.GetStudentDetailsRequest;
import booking_site.xws_proj.soap.beans.GetStudentDetailsResponse;
import booking_site.xws_proj.soap.beans.StudentDetails;

@Endpoint
public class StudentDetailsEndpoint {

  @PayloadRoot(namespace = "http://beans.soap.xws_proj.booking_site", localPart = "GetStudentDetailsRequest")
  @ResponsePayload
  public GetStudentDetailsResponse processCourseDetailsRequest(HttpServletRequest httpRequest, @RequestPayload GetStudentDetailsRequest request) {
    GetStudentDetailsResponse response = new GetStudentDetailsResponse();
    
//    System.out.println(httpRequest.getAttribute("Content-Type"));
    StudentDetails studentDetails = new StudentDetails();
    studentDetails.setId(request.getId());
    studentDetails.setName("Adam");
    studentDetails.setPassportNumber("E1234567");
    
    response.setStudentDetails(studentDetails);
    
    return response;
  }

}