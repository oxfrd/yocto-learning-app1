DESCRIPTION = "Snake game in terminal based on ncurses"
HOMEPAGE = "https://github.com/alexdantas/nSnake"
SECTION = "games"
SUMMARY = "Terminal based snake game with graphical interface"
AUTHOR = "Alex Dantas <eu@alexdantas.net>"

LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"

SRC_URI = "git://github.com/alexdantas/nSnake.git;branch=master"
PV = "1.0+git"
SRCREV = "d018237c22beabb99ec727e73c3e04e580edcebf"

# Set source directory when git is used
S = "${WORKDIR}/git"

# Enable proper bbclasses
inherit pkgconfig generate-build-info

DEPENDS += " ncurses"

TARGET_CC_ARCH += "${LDFLAGS}"

do_compile() {
    oe_runmake
}

do_install() {
    oe_runmake install \
        DESTDIR=${D} \
        PREFIX=/usr \
        GAMEDIR=${bindir} \
        BINDIR=${bindir} \
        DATADIR=${datadir} \
        MANPREFIX=${mandir} \
        MANDIR=${mandir}
}

FILES:${PN} += " ${bindir}/nsnake ${datadir}/games ${datadir}/games/* ${datadir}/icons ${datadir}/icons/*"
