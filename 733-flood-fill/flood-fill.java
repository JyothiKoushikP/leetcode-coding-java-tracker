class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int colour = image[sr][sc];
        if(colour != newColor) {
            floodFill(image,sr,sc,colour,newColor);
        }
        return image;
    }

    public void floodFill(int[][] image, int sr, int sc, int colour, int newColour) {
        if(image[sr][sc] == colour) {
            image[sr][sc] = newColour;
            if(sr >= 1) floodFill(image,sr-1,sc,colour,newColour);
            if(sc >= 1) floodFill(image,sr,sc-1,colour,newColour);
            if(sr+1 < image.length) floodFill(image,sr+1,sc,colour,newColour);
            if(sc+1 < image[0].length) floodFill(image,sr,sc+1,colour,newColour);
        }
    }

}