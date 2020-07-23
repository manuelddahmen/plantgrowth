
/*
 * This file is part of Plants-Growth-2
 *     Plants-Growth-2 is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     Plants-Growth-2 is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with Plants-Growth-2.  If not, see <http://www.gnu.org/licenses/>.
 */

/*
 * This file is part of Plants-Growth-2
 *     Plants-Growth-2 is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     Plants-Growth-2 is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with Plants-Growth-2.  If not, see <http://www.gnu.org/licenses/>.
 */

/*
 * This file is part of Plants-Growth-2
 *     Plants-Growth-2 is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     Plants-Growth-2 is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with Plants-Growth-2.  If not, see <http://www.gnu.org/licenses/>.
 */

/*
 * This file is part of Plants-Growth-2
 *     Plants-Growth-2 is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     Plants-Growth-2 is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with Plants-Growth-2.  If not, see <http://www.gnu.org/licenses/>.
 */

/*
 * This file is part of Plants-Growth-2
 *     Plants-Growth-2 is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     Plants-Growth-2 is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with Plants-Growth-2.  If not, see <http://www.gnu.org/licenses/>.
 */

/*
 * This file is part of Plants-Growth-2
 *     Plants-Growth-2 is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     Plants-Growth-2 is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with Plants-Growth-2.  If not, see <http://www.gnu.org/licenses/>.
 */

/*
 * This file is part of Plants-Growth-2
 *     Plants-Growth-2 is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     Plants-Growth-2 is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with Plants-Growth-2.  If not, see <http://www.gnu.org/licenses/>.
 */

/*
 * This file is part of Plants-Growth-2
 *     Plants-Growth-2 is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     Plants-Growth-2 is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with Plants-Growth-2.  If not, see <http://www.gnu.org/licenses/>.
 */

package one.empty3.growth.graphics.test;


import one.empty3.library.*;
import one.empty3.library.core.testing.TestObjetStub;
import one.empty3.library.core.tribase.TRISphere;
import one.empty3.growth.*;
import one.empty3.growth.graphics.Rotation;
import one.empty3.growth.graphics.Rotation2;
import one.empty3.growth.graphics.Turtle3D_1;
import one.empty3.growth.graphics.Turtle3D_3;
import junit.framework.TestCase;

import java.awt.*;
import java.awt.image.BufferedImage;

import static one.empty3.growth.graphics.Rotation.rotate;

public class Turtle3DTest extends TestCaseExtended {

    @Override
    public void setUp() throws Exception {
        super.setUp();

    }

    public ZBuffer fct() {
        ZBuffer z = ZBufferFactory.instance(1600, 1200);
        z.backgroundTexture(new ColorTexture(new Color(90, 160, 50)));
        Turtle3D_1 turtle3D;
        Camera camera = (new Camera(new Point3D(0., 0., -200.), new Point3D(0., 0., 0.)));

        turtle3D = new Turtle3D_1(z);

        turtle3D.setColor(Color.BLACK);
        turtle3D.line(100);
        turtle3D.rotateU(Math.PI / 2);
        turtle3D.rotateU(Math.PI / 2);
        turtle3D.line(100);
        turtle3D.rotateU(Math.PI / 2);
        turtle3D.line(100);
        turtle3D.rotateU(Math.PI / 2);
        turtle3D.line(100);
        return z;
    }

    public void testSquaresXYZaxis() {
        writeImage(fct());

    }

    public void testSquaresXYZaxis_3() {
        ZBuffer z = ZBufferFactory.instance(1600, 1200);
        ColorTexture colorTexture = new ColorTexture(new Color(140, 50, 100));
        z.backgroundTexture(colorTexture);
        z.camera(new Camera(new Point3D(0., 0., -200.), new Point3D(0., 0., 0.)));
        Turtle3D_3 turtle3D = new Turtle3D_3();

        turtle3D.setzBuffer(z);


        turtle3D.setColor(Color.BLACK);
        turtle3D.line(100);
        turtle3D.rotL(Math.PI / 2);
        turtle3D.line(100);
        turtle3D.rotL(Math.PI / 2);
        turtle3D.line(100);
        turtle3D.rotL(Math.PI / 2);
        turtle3D.line(100);
        turtle3D.rotL(Math.PI / 2);


        writeImage(turtle3D.getzBuffer());

    }


    public static class TestBasic extends TestCase {
        @Override
        public void setUp() throws Exception {
            super.setUp();
        }

        public void generate1(LSystem lSystem) throws NotWellFormattedSystem {
            lSystem.applyRules();
        }

        public void test0() {
            assertTrue(new SymbolSequence(new Symbol('A')).equals(new SymbolSequence(new Symbol('A'))));
        }

        public void testA() throws NotWellFormattedSystem {

            LSystem lSystem = new LSystem();
            lSystem.init();
            SymbolSequence a1 = new SymbolSequence(new Symbol('A'));
            SymbolSequence a = new SymbolSequence(new Symbol('A'));
            lSystem.addRule(a, a1);


            lSystem.setCurrentSymbols("A");

            System.out.println(lSystem);

            lSystem.applyRules();


            System.out.println(lSystem);

            assertTrue(lSystem.getCurrentSymbols().equals(new SymbolSequence(new Symbol('A'))));

        }

        public void generateN(LSystem lSystem, int n) throws NotWellFormattedSystem {
            SymbolSequence ab = new SymbolSequence();
            ab.add(new Symbol('A'));
            ab.add(new Symbol('B'));

            SymbolSequence a1 = new SymbolSequence(new Symbol('A'));
            SymbolSequence b = new SymbolSequence(new Symbol('B'));
            SymbolSequence a = new SymbolSequence(new Symbol('A'));

            lSystem.addRule(a, ab);// a -> ab
            lSystem.addRule(b, a1);// b -> a

            System.out.println("BEFORE" + lSystem.toString());
            for (int i = 0; i < n; i++) {

                generate1(lSystem);

                //System.out.println("AFTER " + (i + 1) + " PASS : " + lSystem.toString());
            }
        }

        public void testGenerate2() throws NotWellFormattedSystem {
            LSystem lSystem = new LSystem();
            lSystem.init();
            lSystem.getCurrentSymbols().add(new Symbol('A'));
            generateN(lSystem, 2);
            SymbolSequence symbolSequence = new SymbolSequence();
            symbolSequence.add(new Symbol('A'));
            symbolSequence.add(new Symbol('B'));
            symbolSequence.add(new Symbol('A'));
            assertTrue(lSystem.getCurrentSymbols().equals(symbolSequence));
        }

        public void testGenerate1() throws NotWellFormattedSystem {

            LSystem lSystem = new LSystem();
            lSystem.init();
            lSystem.getCurrentSymbols().add(new Symbol('A'));

            // run
            generateN(lSystem, 1);

            // Waited for:
            SymbolSequence symbolSequence = new SymbolSequence();
            symbolSequence.add(new Symbol('A'));
            symbolSequence.add(new Symbol('B'));

            // evaluate the answer
            assertTrue(lSystem.getCurrentSymbols().equals(symbolSequence));
        }
    }

    public static class TestMethodEqualsSymbol extends TestCase {
        @Override
        public void setUp() throws Exception {
            super.setUp();
        }

        public void testEmpty() {
            SymbolSequence a = new SymbolSequence();
            SymbolSequence b = new SymbolSequence();

            assertTrue(a.equals(b));
        }

        public void testEmpty2() {
            assertFalse(new SymbolSequence().equals(new SymbolSequence(new Symbol('a'))));
        }

        public void test1symbolDiff() {
            SymbolSequence a = new SymbolSequence(new Symbol('a'));
            SymbolSequence b = new SymbolSequence(new Symbol('b'));

            assertFalse(a.equals(b));
        }

        public void test1symbolId() {
            SymbolSequence a = new SymbolSequence(new Symbol('a'));
            SymbolSequence b = new SymbolSequence(new Symbol('a'));

            assertTrue(a.equals(b));
        }
    }

    public static class TestRotation extends TestCase {
        @Override
        public void setUp() throws Exception {
            super.setUp();
        }


        public void testRotationIdent1() {
            Point3D x = rotate(Point3D.O0, Point3D.X,
                    2 * Math.PI, Point3D.Y);
            Point3D y = Point3D.Y;

            assertEqualsPoint3D(x, y, 0.1);

        }

        public void testRotationIdent2() {
            Point3D x = rotate(Point3D.O0, Point3D.X,
                    2 * Math.PI, Point3D.X);
            Point3D y = Point3D.X;

            assertEqualsPoint3D(x, y, 0.1);

        }

        public void testRotationIdent3() {
            Point3D x = rotate(Point3D.O0, Point3D.X,
                    2 * Math.PI, Point3D.Z);
            Point3D y = Point3D.Z;

            assertEqualsPoint3D(x, y, 0.1);

        }

        public void testRotation90() {
            Point3D x = rotate(Point3D.O0, Point3D.X,
                    Math.PI, Point3D.Z);
            Point3D y = Point3D.Z.mult(-1);

            assertEqualsPoint3D(x, y, 0.1);


        }

        public void testRotationNonO() {
            Point3D x = rotate(Point3D.X, new Point3D(10., 0., 0.),
                    Math.PI, new Point3D(3., 5., 5.));
            Point3D y = new Point3D(3., -5., -5.);

            assertEqualsPoint3D(x, y, 0.1);

        }

        public void testRotation180() {
            Point3D x = rotate(new Point3D(11., 0., 0.), new Point3D(10., 0., 0.),
                    Math.PI, new Point3D(3., 5., 0.));
            Point3D y = new Point3D(3., -5., 0.);

            assertEqualsPoint3D(x, y, 0.1);

        }

        public void testRotation30deg() {
            Point3D x = new Point3D(3., 5., 5.);
            Point3D y = x;

            for (int i = 0; i < 12 * 2; i++) {
                x = rotate(Point3D.X, new Point3D(10., 0., 0.),
                        Math.PI / 6, x);
            }


            assertEqualsPoint3D(x, y, 0.1);

        }

        public void testRotation0degRandomPoint() {
            Point3D x = Point3D.random(10.);

            Point3D y = rotate(Point3D.X, new Point3D(10., 0., 0.),
                    0., x);

            assertEqualsPoint3D(x, y, 0.1);

        }

        public void testRotation0degRandomAxe() {
            Point3D a = Point3D.random(10.);
            Point3D b = Point3D.random(10.);

            Point3D y = rotate(a, b,
                    0., Point3D.X);

            assertEqualsPoint3D(Point3D.X, y, 0.1);

        }

        public void testRotation360degRandomAxe() {
            Point3D a = Point3D.random(10.);
            Point3D b = Point3D.random(10.);

            Point3D y = rotate(a, b,
                    2 * Math.PI, Point3D.X);

            assertEqualsPoint3D(Point3D.X, y, 0.1);

        }

        public void assertEqualsPoint3D(Point3D x, Point3D y, double delta) {
            for (int i = 0; i < 3; i++) {
                assertEquals(y.get(i), x.get(i), delta);
            }
        }

        public void testRotationMethode2() {
            Rotation2 rotation2 = new Rotation2();

            Point3D intersection = rotation2.projection(Point3D.X, Point3D.Y, new Point3D(6, 5, 6));
            assertEqualsPoint3D(intersection, new Point3D(1., 5., 0.), 0.001);

        }

    }

    public static class TestRotation2 extends TestObjetStub {


        private Color random() {
            float r = Math.abs((float) Math.random());
            float g = Math.abs((float) Math.random());
            float b = Math.abs((float) Math.random());
            double n = Math.sqrt(r * r + g * g + b * b);
            return new Color((float) (r / n), (float) (g / n), (float) (b / n));
        }

        public void testScene() {
            double MAX = 200.0;
            double MAXCERLE = 10;
            Point3D p0 = Point3D.Y;
            p0.texture(new ColorTexture(Color.BLACK));
            for (int axeNo = 0; axeNo < 10; axeNo++) {
                Point3D random = Point3D.random(10.);
                Point3D random2 = Point3D.random(10.);
                Color color1 = random();
                Color color2 = random();
                for (int i = 0; i < MAX; i++) {
                    //Color color = CouleurOutils.couleurRatio(color1, color2, i/MAX);
                    one.empty3.growth.graphics.Rotation rotation = new Rotation(random, Point3D.Y, 2 * Math.PI * i / MAX);
                    Point3D p = rotation.rotate(random2);
                    p.texture(new ColorTexture(color1));
                    SegmentDroite segmentDroite = new SegmentDroite(p0, p);
                    segmentDroite.texture(new ColorTexture(color1));
                    TRISphere triSphere = new TRISphere(p, 1.0);
                    triSphere.texture(new ColorTexture(color1));
                    scene().add(segmentDroite);
                    p0 = p;
                    camera().setEye(new Point3D(0., 0., -1000.0));
                }
            }
        }

        public static void main(String[] args) {
            TestRotation2 test = new TestRotation2();
            test.loop(false);
            new Thread(test).start();
        }
    }

    public static class TestRotation2_methodeBis extends TestCaseExtended {
        @Override
        public void setUp() throws Exception {
            super.setUp();
        }


        private Rotation2 rot = new Rotation2();

        private Point3D rotate(Point3D A, Point3D B,
                               double angle, Point3D X)

        {
            return rot.rotation(X, A, B, angle);
        }

        public void testRotationIdent1() {
            Point3D x = rot.rotation(Point3D.Y, Point3D.X,
                    Point3D.O0, 2 * Math.PI);
            Point3D y = Point3D.Y;

            assertEqualsPoint3D(x, y, 0.1);

        }

        public void testRotationIdent2() {
            Point3D x = rotate(Point3D.O0, Point3D.X,
                    2 * Math.PI, Point3D.X);
            Point3D y = Point3D.X;

            assertEqualsNaNPoint3D(x);
        }


        public void testRotationIdent3() {
            Point3D x = rotate(Point3D.O0, Point3D.X,
                    2 * Math.PI, Point3D.Z);
            Point3D y = Point3D.Z;

            assertEqualsPoint3D(x, y, 0.1);

        }

        public void testRotation90() {
            Point3D x = rotate(Point3D.O0, Point3D.X,
                    Math.PI, Point3D.Z);
            Point3D y = Point3D.Z.mult(-1);

            assertEqualsPoint3D(x, y, 0.1);


        }

        public void testRotationNonO() {
            Point3D x = rotate(Point3D.X, new Point3D(10., 0., 0.),
                    Math.PI, new Point3D(3., 5., 5.));
            Point3D y = new Point3D(3., -5., -5.);

            assertEqualsPoint3D(x, y, 0.1);

        }

        public void testRotation180() {
            Point3D x = rotate(new Point3D(11., 0., 0.), new Point3D(10., 0., 0.),
                    Math.PI, new Point3D(3., 5., 0.));
            Point3D y = new Point3D(3., -5., 0.);

            assertEqualsPoint3D(x, y, 0.1);

        }

        public void testRotation30deg() {
            Point3D x = new Point3D(3., 5., 5.);
            Point3D y = x;

            for (int i = 0; i < 12 * 2; i++) {
                x = rotate(Point3D.X, new Point3D(10., 0., 0.),
                        Math.PI / 6, x);
            }


            assertEqualsPoint3D(x, y, 0.1);

        }

        public void testRotation30degRandomAxe() {
            Point3D A = Point3D.random(100.);
            Point3D B = Point3D.random(100.);
            Point3D X = Point3D.random(100.);
            Point3D Y = X;

            for (int i = 0; i < 12; i++) {
                X = rotate(A, B, Math.PI / 6, X);
            }


            assertEqualsPoint3D(X, Y, 0.1);

        }

        public void testRotation0degRandomPoint() {
            Point3D x = Point3D.random(10.);

            Point3D y = rotate(Point3D.X, new Point3D(10., 0., 0.),
                    0., x);

            assertEqualsPoint3D(x, y, 0.1);

        }

        public void testRotation0degRandomAxe() {
            Point3D a = Point3D.random(10.);
            Point3D b = Point3D.random(10.);

            Point3D y = rotate(a, b,
                    0, Point3D.X);

            assertEqualsPoint3D(Point3D.X, y, 0.1);

        }

        public void testRotation360degRandomAxe() {
            Point3D a = Point3D.random(10.);
            Point3D b = Point3D.random(10.);

            Point3D y = rotate(a, b,
                    2 * Math.PI, Point3D.X);

            assertEqualsPoint3D(Point3D.X, y, 0.1);

        }

        public void testRotation360deg300RandomAxe() {
            BufferedImage image = new BufferedImage(1600, 1200, BufferedImage.TYPE_INT_RGB);
            Graphics graphics = image.getGraphics();
            graphics.setColor(Color.YELLOW);
            Point3D y = Point3D.O0;
            for (double angle = 0; angle < 2 * Math.PI; angle += 2 * Math.PI / 1000) {
                Point3D a = Point3D.random(50.);
                Point3D b = Point3D.random(50.);


                y = rotate(a, b,
                        angle, y);

                Point3D plus = y.plus(new Point3D(image.getWidth() / 2., image.getHeight() / 2., 0.));
                graphics.drawLine((int)(double) plus.getX(), (int)(double) plus.getY(), (int)(double) plus.getX(), (int)(double) plus.getY());

                Point3D y2 = y;

                for (int i = 0; i < 1000; i++) {
                    Point3D c = Point3D.random(50.);
                    Point3D d = Point3D.random(50.);
                    double angleB = 2 * Math.PI / 1000;
                    y2 = rotate(c, d,
                            angleB, y2);
                    plus = y2.plus(new Point3D(image.getWidth() / 2., image.getHeight() / 2., 0.));
                    graphics.drawLine((int) plus.getX(), (int) plus.getY(), (int) plus.getX(), (int) plus.getY());

                }
            }
            writeImage(image);
        }


        public void testRotationMethode2() {
            Rotation2 rotation2 = new Rotation2();

            Point3D intersection = rotation2.projection(Point3D.X, Point3D.Y, new Point3D(6., 5., 6.));
            assertEqualsPoint3D(intersection, new Point3D(1., 5., 0.), 0.001);

        }

    }
}
