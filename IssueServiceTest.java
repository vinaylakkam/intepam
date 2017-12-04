import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;


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
		when(issueRepository.getIssue(issueUpdate)).thenReturn(repoIssue);
		repoIssue.setStatus("IN_PROGRESS");
		when(issueRepository.update(issueUpdate)).thenReturn(repoIssue);
		Assert.assertSame(issueService.update(issueUpdate), repoIssue);
	}

	@Test(expected = InvalidIssueStatusException.class)
	public void testValidationFail() {
		Issue repoIssue = new Issue();
		repoIssue.setIssueId(123);
		repoIssue.setStatus("COMPLETED");
		Issue issueUpdate = new Issue();
		issueUpdate.setIssueId(123);
		issueUpdate.setStatus("IN_PROGRESS");
		when(issueRepository.getIssue(issueUpdate)).thenReturn(repoIssue);
		issueService.update(issueUpdate);
	}

}
