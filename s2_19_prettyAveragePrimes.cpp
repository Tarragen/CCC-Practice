#include <iostream>
#include <vector>
#include <unordered_set>
#include <algorithm>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    
    vector<int> nums;
    unordered_set<int> primes;
    vector<int> primesArr;
    
    int pNum, max = INT_MIN;
    cin >> pNum;
    nums.resize(pNum);
    
    for(int i = 0; i < pNum; i++) {
        cin >> nums[i];
        max = std::max(max, nums[i]);
    }
    
    // Sieve of Eratosthenes implementation
    vector<bool> isPrime(max * 2 + 1, true);
    isPrime[0] = isPrime[1] = false;
    
    for(int i = 2; i * i <= max * 2; i++) {
        if(isPrime[i]) {
            for(int j = i * i; j <= max * 2; j += i) {
                isPrime[j] = false;
            }
        }
    }
    
    // Collect primes
    for(int i = 2; i <= max * 2; i++) {
        if(isPrime[i]) {
            primes.insert(i);
            primesArr.push_back(i);
        }
    }
    
    for(int num : nums) {
        int curr = num * 2;
        for(int j : primesArr) {
            if(primes.find(curr - j) != primes.end()) {
                cout << j << " " << (curr - j) << "\n";
                break;
            }
        }
    }
    
    return 0;
}
