# My git challenge
Welcome to my implementation of the "Build Your Own Git" challenge from [CodeCrafters.io](https://codecrafters.io)! 🚀

## About the Challenge

In this challenge, I built a simplified version of Git, a small service that can:
- Initialize a repository
- Create commits
- Clone a public repository

Along the way, I got to learn about the `.git` directory, Git objects (blobs, commits, trees, etc.), Git's transfer protocols, and more.
## Testing Locally

To avoid accidentally damaging your repository's `.git` folder, it's recommended to test in a separate directory.

You can do this by:

### Creating a New Temporary Directory:

```bash
mkdir -p /tmp/testing && cd /tmp/testing
```
### Running Git Implementation from There:
```bash
/tsts-git/your_git.sh init
```
### To Simplify Testing, Consider Adding a Shell Alias:
```bash
alias mygit=/path-to-the-repo/tsts-git/your_git.sh

mkdir -p /tmp/testing && cd /tmp/testing
mygit init
```

## Conclusion
This challenge was an excellent opportunity to dive deep into the inner workings of Git, and I'm excited to continue expanding my understanding and skills in this area. 

Happy coding! 😄

**Note**: If you're viewing this on GitHub, head over to [the challenge](https://app.codecrafters.io/courses/git/overview) to try it yourself!
