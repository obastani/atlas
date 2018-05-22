ATLAS
=====

ATLAS is a tool for automatically inferring points-to specifications.

For a detailed introduction to ATLAS, see:

- [**Active Learning of Points-To Specifications**](http://arxiv.org/abs/1711.03239)

Table of Contents
=====
1. Downloading and Building ATLAS
2. Contact

Downloading and Building ATLAS
=====

The ATLAS source code is available on GitHub under the Apache Software License version 2.0 at https://github.com/obastani/atlas. To check out the ATLAS source code repository, run:

    $ git clone https://github.com/obastani/atlas.git

To build ATLAS, run:

    $ cd atlas
    $ ant

To run ATLAS, run:

    $ ant run

Finally, both the specifications inferred by ATLAS and the handwritten ground truth points-to specifications are available in the `models/` folder.

Contact
=====

For questions, feel free to contact `obastani@cs.stanford.edu`.
