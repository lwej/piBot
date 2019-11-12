# piBot
A small rPi robot that drives through a maze
The piBot runs a server via sockets that accepts a file from the client.
For now it works with a specific file that should look like this.

00000N00000
00000N00000
000EEN00000
000N0000000
000NWWW0000
000000N0000

The piBot reads the file and turns the lines into a char array , deleting the zeros.
Then it reverses the array and returns the correct way to go since the start position is from the bottom.

In the movement class there are some additional movement options. 
(In case they are needed to improve the driving path. For use when driving through a corner part of the maze.)

