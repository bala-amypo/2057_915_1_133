@PostMapping("/register")
public ResponseEntity<?> register(@RequestBody RegisterRequestDto registration) {
    authService.register(registration); // This returns void
    return ResponseEntity.ok("User registered successfully"); // Return this instead
}