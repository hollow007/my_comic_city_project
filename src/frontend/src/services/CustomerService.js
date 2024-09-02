class CustomerService {
    constructor() {
    this.apiUrl = '/api/comiccity/Customer'; // Base URL for the API, assuming you're using a proxy
}
// Helper method to handle fetch requests
    async request(url, options) {
        try {
            const response = await fetch(url, options);
            if (!response.ok) {
                throw new Error(`Network response was not ok: ${response.statusText}`);
            }
            return options.method === 'DELETE' ? response.text() : response.json();
        } catch (error) {
            console.error('Fetch error:', error);
            throw error;
        }
    }
// Create a new customer
    async createCustomer(customer) {
        const url = `${this.apiUrl}/create`;
        return await this.request(url, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(customer),
        });
    }
}
export default new CustomerService();