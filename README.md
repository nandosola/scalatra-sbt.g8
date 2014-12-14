# Scalatra sbt project #


[g8](http://github.com/n8han/giter8) template to get a Scalatra REST microservice up and running quickly. It includes:
* JSON Support
* Akka

## Use this template ##

- [Install giter8 (g8)](https://github.com/n8han/giter8)
- Get the g8 template and run it:

```sh
$ g8 nandosola/scalatra-sbt
$ cd <name-of-app>
$ ./sbt
> container:start
```

- Open [http://localhost:8080/](http://localhost:8080/) in your browser.

## Modify this template ##

- [Install sbt](http://www.scala-sbt.org/), version 0.13.0 or higher.
- Fork [scalatra/scalatra-sbt.g8](https://github.com/scalatra/scalatra-sbt.g8) on GitHub to your account.
Let's assume your account is "foo".
- Clone it.

```sh
$ git clone git@github.com:foo/scalatra-sbt.g8.git
```

- Now make your desired changes.
- Do a local deploy of your modified template and try it out.

```sh
$ sbt
> g8Test # must result in SUCCESS
> exit
$ cd target/sbt-test/default-*/scripted
$ sbt
$ container:start
$ browse # starts browser for you, or manually open http://localhost:8080 to verify
```

- If you like your new template, push it to GitHub.

```sh
$ cd /path/to/scalatra-sbt.g8.git
$ git push
```

- You can now access your modified template using g8.

```sh
$ cd
$ g8 foo/scalatra-sbt.g8
```

- If you'd like to share your changes, send a pull request.
