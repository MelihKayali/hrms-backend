package kodlama.io.HRMS.core.results.adapters;

import java.time.LocalDate;

import kodlama.io.HRMS.entities.concretes.CandidateUser;

public interface UserCheckService {
//	Boolean checkIfRealPerson(String nationalityId, String firstName, String lastName, LocalDate dateOfBirthYear); 
//	Boolean checkRealPerson(CandidateUser candidateUser); 
//	Boolean checkRealPerson(String identityNumber, String firstName, String lastName);
//Object checkRealPerson(String identityNumber, String firstName, String lastName); 
	
	Boolean checkRealPerson(String identityNumber, String firstName, String lastName);
	
}
