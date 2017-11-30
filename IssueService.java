@Service
public class IssueService {

	@Autowired
	private IssueRepository issueRepository;

	public Issue update(Issue issue) throws InvalidIssueStatusException, IssueUpdateException{

		// TODO: Validate the issue.status first;
		// Status can be updated from CREATED to IN_PROGRESS to COMPLETED.
		if(issue ==  null || issueRepository == null || 
				(getIssueStatus(issue.getStatus()) - getIssueStatus(issueRepository.getCurrentStatus(issue)) != 1)){
			throw new InvalidIssueStatusException("Issue status is invalid!");
		}		

		// TODO: Save the issue using issueRepository
		issueRepository.updateIssue(issue);
	}
	
	private int getIssueStatus(String issueRepoStatus){
		if("CREATED".equalsIgnoreCase(issueRepoStatus)){
			return 1;
		} else if("IN_PROGRESS".equalsIgnoreCase(issueRepoStatus)){
			return 2;
		} else if("COMPLETED".equalsIgnoreCase(issueRepoStatus)){
			return 3;
		} else{
			return -10;
		}
	}
}
