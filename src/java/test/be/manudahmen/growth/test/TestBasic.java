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
 *     Foobar is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     Foobar is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with Foobar.  If not, see <http://www.gnu.org/licenses/>.
 */

/*
 * This file is part of Plants-Growth-2
 *     Foobar is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     Foobar is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with Foobar.  If not, see <http://www.gnu.org/licenses/>.
 */

package be.manudahmen.growth.test;

import be.manudahmen.growth.LSystem;
import be.manudahmen.growth.NotWellFormattedSystem;
import be.manudahmen.growth.Symbol;
import be.manudahmen.growth.SymbolSequence;
import junit.framework.TestCase;

public class TestBasic extends TestCase {
    public void generate1(LSystem lSystem) {
        try {
            lSystem.applyRules();
        } catch (NotWellFormattedSystem notWellFormattedSystem) {
            notWellFormattedSystem.printStackTrace();
        }
    }

    public void test0() {
        assertTrue(new SymbolSequence(new Symbol('A')).equals(new SymbolSequence(new Symbol('A'))));
    }

    public void testA() {

        LSystem lSystem = new LSystem();
        lSystem.init();
        SymbolSequence a1 = new SymbolSequence(new Symbol('A'));
        SymbolSequence a = new SymbolSequence(new Symbol('A'));
        lSystem.addRule(a, a1);

        lSystem.getCurrentSymbols().add(new Symbol('A'));

        //System.out.println(lSystem);

        try {
            lSystem.applyRules();
        } catch (NotWellFormattedSystem notWellFormattedSystem) {
            notWellFormattedSystem.printStackTrace();
        }


        //System.out.println(lSystem);

        assertTrue(lSystem.getCurrentSymbols().equals(new SymbolSequence(new Symbol('A'))));

    }

    public void generateN(LSystem lSystem, int n) {
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

    public void testGenerate2() {
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

    public void testGenerate1() {

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
