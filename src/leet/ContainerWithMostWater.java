package leet;

public class ContainerWithMostWater {
	public int maxArea(int[] height)
	{
		if(height == null || height.length <= 1)
			return 0;
		int max = 0;
		int l=0;
		int r = height.length - 1;
		while(l < r)
		{
			int temp = Math.min(height[l],height[r])*(r-l);
			if(temp > max)
				max = temp;
			//move the shorter side
			if(height[l] > height[r])
			{
				while(r>l & height[r-1] < height[r])
					r--;
				r--;
			}
			else
			{
				while(l<r & height[l+1] < height[l])
					l++;
				l++;
			}
		}
		
		return max;
	}

}
