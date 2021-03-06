/*
 *  Copyright 2010 BetaSteward_at_googlemail.com. All rights reserved.
 *
 *  Redistribution and use in source and binary forms, with or without modification, are
 *  permitted provided that the following conditions are met:
 *
 *     1. Redistributions of source code must retain the above copyright notice, this list of
 *        conditions and the following disclaimer.
 *
 *     2. Redistributions in binary form must reproduce the above copyright notice, this list
 *        of conditions and the following disclaimer in the documentation and/or other materials
 *        provided with the distribution.
 *
 *  THIS SOFTWARE IS PROVIDED BY BetaSteward_at_googlemail.com ``AS IS'' AND ANY EXPRESS OR IMPLIED
 *  WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
 *  FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL BetaSteward_at_googlemail.com OR
 *  CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 *  CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 *  SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
 *  ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 *  NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF
 *  ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 *  The views and conclusions contained in the software and documentation are those of the
 *  authors and should not be interpreted as representing official policies, either expressed
 *  or implied, of BetaSteward_at_googlemail.com.
 */
package mage.sets.magic2014;

import java.util.UUID;
import mage.MageInt;
import mage.ObjectColor;
import mage.abilities.Ability;
import mage.abilities.common.EntersBattlefieldTriggeredAbility;
import mage.abilities.effects.common.ExileCardYouChooseTargetOpponentEffect;
import mage.abilities.keyword.IntimidateAbility;
import mage.cards.CardImpl;
import mage.constants.CardType;
import mage.constants.Rarity;
import mage.filter.common.FilterCreatureCard;
import mage.filter.predicate.Predicates;
import mage.filter.predicate.mageobject.ColorPredicate;
import mage.target.common.TargetOpponent;

/**
 *
 * @author LevelX2
 */
public class LifebaneZombie extends CardImpl {

    private static final FilterCreatureCard filter = new FilterCreatureCard("a green or white creature card");
    static {
        filter.add(Predicates.or(
                new ColorPredicate(ObjectColor.GREEN),
                new ColorPredicate(ObjectColor.WHITE)));
    }

    public LifebaneZombie(UUID ownerId) {
        super(ownerId, 101, "Lifebane Zombie", Rarity.RARE, new CardType[]{CardType.CREATURE}, "{1}{B}{B}");
        this.expansionSetCode = "M14";
        this.subtype.add("Zombie");
        this.subtype.add("Warrior");

        this.color.setBlack(true);
        this.power = new MageInt(3);
        this.toughness = new MageInt(1);

        // Intimidate
        this.addAbility(IntimidateAbility.getInstance());
        // When Lifebane Zombie enters the battlefield, target opponent reveals his or her hand. You choose a green or white creature card from it and exile that card.
        Ability ability = new EntersBattlefieldTriggeredAbility(new ExileCardYouChooseTargetOpponentEffect(filter));
        ability.addTarget(new TargetOpponent());
        this.addAbility(ability);        
    }

    public LifebaneZombie(final LifebaneZombie card) {
        super(card);
    }

    @Override
    public LifebaneZombie copy() {
        return new LifebaneZombie(this);
    }
}
