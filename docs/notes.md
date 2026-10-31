# Technical Notes

## Biggest Docker problem:

When I first ran the Docker build, I got an error because I forgot to copy the src folder in the Dockerfile. I fixed it by using COPY src ./src. Another problem was that the port wasn't working, so I added -p 8080:8080 in the run command.

## Most important Git lesson:

I learned that I should make multiple commits, not just one big commit. Using messages like "feat:", "docs:", and "chore:" made my repo look organized like real developers do.
