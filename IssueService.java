import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IssueService {

	@Autowired
	private IssueRepository issueRepository;

	public Issue update(Issue issue) throws InvalidIssueStatusException {

		// TODO: Validate the issue.status first;
		// Status can be updated from CREATED to IN_PROGRESS to COMPLETED.
		if(!isValidStatus(issue)){
			throw new InvalidIssueStatusException("Issue status is invalid!");
		}
		
		// TODO: Save the issue using issueRepository
		return issueRepository.updateIssue(issue);
	}
	
	/**
	 * Checks if issue status is valid to update
	 * 
	 * @param issue
	 * @return
	 */
	private boolean isValidStatus(Issue issue) {
		try {
			if (issue == null
					|| issue.getStatus() == null
					|| (IssueStatus.valueOf(issue.getStatus().toUpperCase())
							- IssueStatus.valueOf(issueRepository.getCurrentStatus(issue).toUpperCase()) < 0)) {
				return false;

			}
		} catch (IllegalArgumentException excep) {
			return false;
		}
		return true;
	}

	/**
	 * 
	 * @author suman
	 * 
	 */
	enum IssueStatus {
		CREATED(1), IN_PROGRESS(2), COMPLETED(3);

		private int value;

		private IssueStatus(int value) {
			this.value = value;
		}
	}
}
