class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int n = properties.length;
        int maxDefense = 0;
        int ans = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (properties[i][1] < maxDefense) {
                ans++;
            }
            else {
                maxDefense = properties[i][1];
            }
        }
        return ans;
    }
}
