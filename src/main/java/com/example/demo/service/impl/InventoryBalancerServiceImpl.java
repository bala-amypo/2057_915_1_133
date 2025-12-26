@Service
public class InventoryBalancerServiceImpl implements InventoryBalancerService {

    @Autowired
    private TransferSuggestionRepository suggestionRepository;

    @Override
    public List<TransferSuggestion> generateSuggestions() {
        // Your existing balancing logic here
        return suggestionRepository.findAll(); 
    }

    @Override
    public List<TransferSuggestion> generateSuggestions(Long storeId) {
        // Filter logic or just call the main one if it handles all
        return generateSuggestions(); 
    }

    @Override
    public TransferSuggestion getSuggestionById(Long id) {
        return suggestionRepository.findById(id).orElse(null);
    }
}