SUMMARY = "Console games for Raspberry Pi 4"
DESCRIPTION = "A selection of console games for Raspberry Pi 4"
PR = "1.0"

inherit packagegroup

RDEPENDS:${PN}:append:raspberrypi4-64 = " \
    nsnake \
    nudoku \
"