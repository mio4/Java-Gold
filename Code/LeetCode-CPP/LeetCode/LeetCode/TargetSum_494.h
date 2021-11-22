#pragma once
#include <vector>
#include <string>
using namespace std;

class Solution {
private:
	int res = 0;
public:
	int findTargetSumWays(vector<int>& nums, int S) {  
		int sum = 0;
		for (int i = 0; i < nums.size(); i++) {
			sum += nums[i];
		}
		if (sum < S)
			return 0;
		recursion(nums, S, 0, 0, true);
		recursion(nums, S, 0, 0, false);
		return res;
	}

	void recursion(vector<int> & nums, int S, int cur_S,int index,bool is_pos) {
		if (is_pos) {
			cur_S += nums[index];
		}
		else {
			cur_S -= nums[index];
		}

		if (index == nums.size() - 1) {
			if (cur_S == S) {
				res++;
			}
		}

		if (index < nums.size()-1) {
			recursion(nums, S, cur_S, index + 1, true);
			recursion(nums, S, cur_S, index + 1, false);
		}
	}
};
