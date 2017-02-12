# Minimal web service template

An opinionated Boot template for minimal web
services. See [boot-new](https://github.com/boot-clj/boot-new).

## Usage

Install a snapshot of the template into your local maven repository:

    boot build

Then create a project based on the template:

    boot -d seancorfield/boot-new new -t web-service -n <name> -a <port> -S

Here `-S` indicates using the snapshot version. Replace the name of your
application in kebab-case for `<name>` and the TCP port for `<port>`, e.g.

    boot -d seancorfield/boot-new new -t web-service -n hello-world -a 8001 -S

This creates a functional Boot project. Executing the `run` task starts a server
listening on the specified port with endpoints:

- `/version` Returns the version.
- `/api-docs` Renders the Swagger API specification.
- `/swagger.json` Returns the raw Swagger API specification.


## License

Copyright © 2017 Bart Frenk.

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
