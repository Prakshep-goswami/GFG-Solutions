class Solution:
    def setMatrixZeroes(self, mat):
        # code here
        all = len(mat)
        store_column = {}
        store_row = {}

        for i in range(all):
            element = len(mat[i])
            zeros = [0]*element

            for j in range(element):
                if mat[i][j] == 0:
                    store_column[j] = 0
                    store_row[i] = 0
                    
        for i in store_row:
            mat[i] = zeros

        if len(store_row) == all:
            return mat

        for i in store_column:
            for j in range(all):
                mat[j][i] = 0

        return mat