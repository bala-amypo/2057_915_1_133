@Override
public List<TransferSuggestion> getSuggestionsForStore(Long storeId) {
    // Both parameters are 'storeId' because we want suggestions 
    // where the store is either the sender OR the receiver.
    return suggestionRepository.findBySourceStoreIdOrDestinationStoreId(storeId, storeId);
}