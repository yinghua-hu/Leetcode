class RandomizedSet {
    Random rand = new Random();
    List<Integer> nums;
    Map<Integer, Integer> num2pos;
    public RandomizedSet() {
        nums = new ArrayList<>();
        num2pos = new HashMap<>();
    }
    
    public boolean insert(int val) {
        if (num2pos.containsKey(val)) {
            return false;
        }
        nums.add(val);
        num2pos.put(val, nums.size() - 1);
        return true;
    }
    
    public boolean remove(int val) {
        if (!num2pos.containsKey(val)) {
            return false;
        }
        int i = num2pos.get(val);
        int last = nums.get(nums.size() - 1);
        num2pos.put(last, i);
        nums.set(i, last);
        nums.remove(nums.size() - 1);
        num2pos.remove(val);
        return true;
    }
    
    public int getRandom() {
        int i = rand.nextInt(nums.size());
        return nums.get(i);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */

/*
ArrayList
insert O(1)
remove O(n)
get O(1)

HashMap

*/
