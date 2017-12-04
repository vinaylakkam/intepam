import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class IssueServiceTest {

	@InjectMocks
	IssueService issueService = new IssueService();

	@Mock
	IssueRepository issueRepository;


	@Test
	public void testSuccessUpdate() {
		Issue repoIssue = new Issue();
		repoIssue.setIssueId(123);
		repoIssue.setStatus("CREATED");
		Issue issueUpdate = new Issue();
		issueUpdate.setIssueId(123);
		issueUpdate.setStatus("IN_PROGRESS");
		Mockito.when(issueRepository.getIssue(issueUpdate)).thenReturn(repoIssue);
		repoIssue.setStatus("IN_PROGRESS");
		Mockito.when(issueRepository.update(issueUpdate)).thenReturn(repoIssue);
		Assert.assertSame(issueService.update(issueUpdate), repoIssue);
		Mockito.verify(issueRepository).getIssue(issueUpdate);
		Mockito.verify(issueRepository).update(issueUpdate);
	}

	@Test(expected = InvalidIssueStatusException.class)
	public void testValidationFail() {
		Issue repoIssue = new Issue();
		repoIssue.setIssueId(123);
		repoIssue.setStatus("COMPLETED");
		Issue issueUpdate = new Issue();
		issueUpdate.setIssueId(123);
		issueUpdate.setStatus("IN_PROGRESS");
		Mockito.when(issueRepository.getIssue(issueUpdate)).thenReturn(repoIssue);
		issueService.update(issueUpdate);
		Mockito.verify(issueRepository).getIssue(issueUpdate);
		Mockito.verify(issueRepository, never()).update(issueUpdate);
	}
	
	@Test(expected = InvalidIssueStatusException.class)
	public void testUpdateFail() {
		Issue repoIssue = new Issue();
		repoIssue.setIssueId(123);
		repoIssue.setStatus("CREATED");
		Issue issueUpdate = new Issue();
		issueUpdate.setIssueId(123);
		issueUpdate.setStatus("IN_PROGRESS");
		Mockito.when(issueRepository.getIssue(issueUpdate)).thenReturn(repoIssue);
		repoIssue.setStatus("IN_PROGRESS");
		Mockito.doThrow(new InvalidIssueStatusException("Issue update failed!"))
			.when(issueRepository.update(issueUpdate));
		issueService.update(issueUpdate);
		Mockito.verify(issueRepository).getIssue(issueUpdate);
		Mockito.verify(issueRepository).update(issueUpdate);
	}

}
