package lab3;

import java.util.List;

public abstract class SpecialNumber {

    public abstract SpecialNumber add(SpecialNumber num) throws Lab3Exception;

    public abstract SpecialNumber divideByInt(int divisor) throws Lab3Exception;

    /**
     * Computes the average special number given a list of special numbers
     * @param nums a list of special number objects
     * @return the average value of special numbers in list nums
     * @throws Lab3Exception if the list is empty or null
     */
    public static SpecialNumber computeAverage(List<SpecialNumber> nums) throws Lab3Exception {
        if (nums == null || nums.isEmpty()) {
            throw new Lab3Exception("List cannot be empty");
        }

        SpecialNumber sum = nums.get(0);

        for (int i = 1; i < nums.size(); i++) {
            sum = sum.add(nums.get(i));
        }
        return sum.divideByInt(nums.size());
    }
}
