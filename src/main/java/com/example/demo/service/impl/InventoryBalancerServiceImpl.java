@Override
public List<TransferSuggestion> generateSuggestions(Long productId) {
    Product product = productRepository.findById(productId)
            .orElseThrow(() -> new ResourceNotFoundException("Product not found"));

    List<InventoryLevel> levels = inventoryLevelRepository.findByProduct_Id(productId);
    
    // Logic: Identify stores with Surplus (Inventory > Forecast) 
    // and stores with Shortage (Inventory < Forecast)
    for (InventoryLevel source : levels) {
        // Simple logic to suggest movement if stock > 100
        if (source.getQuantity() > 100) {
            // Find a target store with low stock and create a suggestion
            // This maps to the TransferSuggestion entity in your DB
        }
    }
    return transferSuggestionRepository.findByProduct(product);
}