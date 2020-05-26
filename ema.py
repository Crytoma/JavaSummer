#Seagull, [22.05.20 15:41]

def twoPluses(grid):
    vertical = n
    horizontal = m
    plus1 = 1
    plus2 = 1
    plus1coords = [0,0]
    plus1size = 0

    grid = replace(grid, n, m, 0)

    for x in range(vertical):
        if x == 0:
            continue

        for y in range(horizontal):
            if y == 0:
                continue

            count = 1
            size = 1

            if grid[x][y] == 'G':
                while expand(grid, x, y, size):
                    count += 4
                    size += 1
                
                if count > plus1:
                    plus1 = count
                    plus1size = size - 1
                    plus1coords[0] = x
                    plus1coords[1] = y
    print(plus1)

    if plus1 != 1:
        grid = replace(grid, plus1coords[0], plus1coords[1], plus1size)                
    else:
        grid[plus1coords[0]][plus1coords[1]] = 'B'
    
    for x in range(vertical):
        if x == 0:
            continue

        for y in range(horizontal):
            if y == 0:
                continue

            count = 1
            size = 1

            if grid[x][y] == 'G':
                while expand(grid, x, y, size):
                    count += 4
                    size += 1
                
                if count > plus2:
                    plus2 = count

    print(plus1 * plus2)
    return plus1 * plus2
    
def replace(grid, x, y, size):
    gridc = [[] for i in range(n)]

    for i in range(n):
        for j in range(m):
            if grid[i][j] == 'G':
                gridc[i].append('G')
            else:
                gridc[i].append('B')
    
    if size != 0:

        for i in range(size):
            gridc[x+size][y] = 'B'
            gridc[x-size][y] = 'B'
            gridc[x][y+size] = 'B'
            gridc[x][y-size] = 'B'

    return gridc

def expand(grid, x, y, size):
    try:
        if grid[x+size][y] == 'G' and x + size < n:
            if grid[x-size][y] == 'G' and x - size > -1:
                if grid[x][y+size] == 'G' and y + size < m:
                    if grid[x][y-size] == 'G' and y - size > -1:
                        return True
        
        return False
    
    except:
        return False