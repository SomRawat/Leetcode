#include <unordered_map>
#include <string>
using namespace std;

class Solution {
public:
    bool canConstruct(string s, int k) {
        // If k is greater than the length of the string, not enough characters.
        if (k > s.length()) {
            return false;
        }

        // Count the frequency of each character.
        unordered_map<char, int> freq;
        for (char c : s) {
            freq[c]++;
        }

        // Count the number of characters with odd frequency.
        int oddCount = 0;
        for (auto& entry : freq) {
            if (entry.second % 2 != 0) {
                oddCount++;
            }
        }

        // To construct k palindromes, the oddCount must not exceed k.
        return oddCount <= k;
    }
};