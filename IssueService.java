@Service
public class IssueService {


   @Autowired
   private IssueRepository issueRepository;
   
   public Issue update(Issue issue) {
		
		// TODO: Validate the issue.status first; 
		// Status can be updated from CREATED to IN_PROGRESS to COMPLETED. 
		
		// TODO: Save the issue using issueRepository
   }
}
