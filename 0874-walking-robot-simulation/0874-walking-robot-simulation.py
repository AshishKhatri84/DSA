class Solution:
    def robotSim(self, commands: List[int], obstacles: List[List[int]]) -> int:
        best_distance = 0
        stage = 0
        my_set = set()
        for obstacle in obstacles:
            my_set.add(tuple(obstacle))
        current_x = 0
        current_y = 0
        for command in commands:
            if command == -1:
                stage = (stage + 1) % 4
            elif command == -2:
                stage = (stage - 1) % 4
            else:
                if stage == 0:
                    for x in range(command):
                        if (current_x,current_y + 1) in my_set:
                            break
                        current_y += 1
                elif stage == 1:
                    for x in range(command):
                        if (current_x + 1,current_y) in my_set:
                            break
                        current_x += 1
                elif stage == 2:
                    for x in range(command):
                        if (current_x,current_y - 1) in my_set:
                            break
                        current_y -= 1
                else:
                    for x in range(command):
                        if (current_x - 1,current_y) in my_set:
                            break
                        current_x -= 1
                best_distance = max(best_distance,current_x*current_x + current_y*current_y)
        return best_distance